package aui.terminus.algebra

import terminus.Program
import terminus.Terminal

final case class Configuration(
    width: Int,
    padding: Int,
    background: Program[Unit] => Program[Unit]
) {
  def innerWidth: Int = width - (2 * padding)
}

trait TerminusConfiguration {
  def config: Configuration
}
