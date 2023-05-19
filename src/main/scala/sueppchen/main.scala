package sueppchen

import scala.scalajs.js
import scala.scalajs.js.annotation.*

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom.document


@main
def main(): Unit = {
    renderOnDomContentLoaded(
        document.getElementById("app"),
        div(h1("SÜPPCHEN!!"))
    )
}