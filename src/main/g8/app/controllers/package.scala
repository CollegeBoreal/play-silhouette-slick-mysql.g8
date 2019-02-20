import java.sql.Timestamp
import java.text.SimpleDateFormat

import play.api.libs.json._

package object controllers {

  implicit object timestampFormat extends Format[Timestamp] {
    val format = new SimpleDateFormat("yyyy-MM-dd:mm::ss")
    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }
    def writes(ts: Timestamp) = JsString(format.format(ts))
  }

}
