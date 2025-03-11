package aui.terminus.algebra

import terminus.Program
import terminus.Terminal

/** Utilities for output */
object Output {
  val newline: Program[Unit] =
    Terminal.write("\r\n")

  def writeLn(line: String): Program[Unit] = {
    Terminal.write(line)
    newline
  }

  def writeRightPadded(output: String, width: Int): Program[Unit] = {
    Terminal.write(output)

    val pad = width - output.size
    if pad > 0 then Terminal.write(" " * pad)
  }
}
