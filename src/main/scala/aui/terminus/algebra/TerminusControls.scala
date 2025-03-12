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

      Terminal.cursor.up(2)
      Terminal.cursor.column(config.padding + 1)
      Terminal.flush()
    }

    Tui(
      height = 2 + config.padding,
      draw = draw,
      initialState = "",
      interact = content => {
        def loop(content: String): String = {
          Terminal.readKey() match {
            case Eof => content
            case Key(modifiers, code) =>
              code match {
                // case KeyCode.BackTab         =>
                case KeyCode.Backspace =>
                  if content.isEmpty() then loop(content)
                  else {
                    val column = content.size + config.padding
                    Terminal.cursor.column(column)
                    Terminal.write(' ')
                    Terminal.cursor.column(column)
                    Terminal.flush()
                    loop(content.take(content.size - 1))
                  }
                // case KeyCode.CapsLock        =>
                case KeyCode.Character(char) =>
                  val updated = content :+ char
                  Terminal.write(char)
                  Terminal.flush()
                  loop(updated)
                // case KeyCode.Delete          =>
                // case KeyCode.Down            =>
                // case KeyCode.End             =>
                case KeyCode.Enter =>
                  Terminal.cursor.down(2)
                  Terminal.cursor.column(1)
                  Terminal.flush()
                  content
                // case KeyCode.Escape          =>
                // case KeyCode.F(value)        =>
                // case KeyCode.Home            =>
                // case KeyCode.Insert          =>
                // case KeyCode.KeypadBegin     =>
                // case terminus.KeyCode.Left   =>
                // case KeyCode.Menu            =>
                // case terminus.KeyCode.Null   =>
                // case KeyCode.NumLock         =>
                // case KeyCode.PageDown        =>
                // case KeyCode.PageUp          =>
                // case KeyCode.Pause           =>
                // case KeyCode.PrintScreen     =>
                // case terminus.KeyCode.Right  =>
                // case KeyCode.ScrollLock      =>
                // case KeyCode.Tab             =>
                // case KeyCode.Up              =>
                // case KeyCode.Unknown(code)   =>
                case other => loop(content)
              }
          }
        }
        loop(content)
      }
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
