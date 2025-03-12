package aui.effect

import aui.algebra.Algebra
import aui.Component

/** A Controller brings the UI to life */
trait Controller[+Alg <: Algebra] {
  def create[Alg2 >: Alg <: Algebra, A](component: Component[Alg2, A]): A
}
