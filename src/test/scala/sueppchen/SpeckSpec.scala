package sueppchen

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec
import org.scalajs.dom.document
import com.raquo.laminar.api.L

class SpeckSpec extends AnyWordSpec with  Matchers {
    "süppchen" should {
        "render" in {
            document.body.innerHTML = "<div id=\"app\"></div>"
            L.render(document.getElementById("app"), sueppchen("Speck"))
            document.getElementById("app").children.length shouldBe 1
            document.getElementById("app").children.head.tagName.toLowerCase shouldBe "div"
            document.getElementById("app").children.head.children.head.tagName.toLowerCase shouldBe "h1"
        }
    }
}
