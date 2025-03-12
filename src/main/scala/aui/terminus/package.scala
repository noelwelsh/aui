package aui.terminus

import aui.Component
import aui.algebra.Controls
import aui.effect.Controller
import aui.terminus.algebra.*
import terminus.*

type Algebra = Controls & TerminusAlgebra
given Algebra: Algebra = new TerminusControls
  with TerminusConfiguration(
    Configuration(60, 2, (program) => Terminal.background.blue(program))
  )

given Controller: Controller[Algebra] =
  new Controller[Algebra] {
    def create[Alg2 >: Algebra <: aui.algebra.Algebra, A](
        component: Component[Alg2, A]
    ): A =
      component(Algebra).create()
  }
