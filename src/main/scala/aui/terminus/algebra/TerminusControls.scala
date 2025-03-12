package aui.terminus.algebra

import aui.algebra.Controls
import aui.algebra.Validation
import terminus.*

trait TerminusControls extends Controls with TerminusAlgebra {
  self: TerminusConfiguration =>
  def textField(
      label: String,
      placeholder: String,
      validation: Validation[String]
  ): Ui[String] =
    val draw: Program[Unit] = {
      backgroundLine
      Output.newline

      backgroundPad
      Output.writeRightPadded(label, config.innerWidth)
      backgroundPad
      Output.newline

      backgroundPad
      Terminal.write(" " * config.innerWidth)
      backgroundPad
      Output.newline

      backgroundLine
      Output.newline
    }

    Tui(
      height = 2 + config.padding,
      draw = draw,
      initialState = (),
      interact = _ => "Foo"
    )

  def choice[A](label: String, options: Seq[(String, A)]): Ui[A] =
    ???

  private lazy val emptyLine = " " * config.width
  private lazy val emptyInnerLine = " " * config.innerWidth

  private lazy val backgroundLine: Program[Unit] =
    config.background(Terminal.write(emptyLine))

  private lazy val backgroundPad: Program[Unit] =
    config.background(Terminal.write(" " * config.padding))
}
