// Copyright (c) Konrad Grzanek
// Created 22.07.19
package telsos.bench;

import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@SuppressWarnings("static-method")
class TestJmhRunner {

  private static final List<Class<?>> BENCH_CLASSES = List.of(
      // BenchCh.class,
      // BenchStreams.class,
      BenchBreadthFirstSearch.class);

  @Test
  void runJmhBenchmarks() throws RunnerException {
    var opts = new OptionsBuilder().warmupIterations(3).measurementIterations(3)
        .forks(1).jvmArgsAppend("-server", "-Xms256m", "-Xmx1024m");

    BENCH_CLASSES.forEach(c -> opts.include(c.getSimpleName()));

    var runResults = new Runner(opts.build()).run();
    assertFalse(runResults.isEmpty());
  }

}
