package aui.syntax

import aui.Component
import aui.algebra.Algebra
import aui.effect.Controller

object all {
  extension [Alg <: Algebra, A](component: Component[Alg, A]) {
    def create()(using controller: Controller[Alg]): A =
      controller.create(component)
  }
}
