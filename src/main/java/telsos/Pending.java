// Copyright (c) Konrad Grzanek
// Created 20.07.19
package telsos;

public interface Pending {

  boolean isPending();

  default boolean isRealized() {
    return !isPending();
  }

}
