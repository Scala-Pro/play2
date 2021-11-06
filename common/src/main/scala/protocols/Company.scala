package protocols

import io.circe.{Decoder, Encoder}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}

case class Company (id: Int, name: String, email: String, phone: String, workerCount: Int)

object Company {
  implicit val decoderUser: Decoder[Company] = deriveDecoder[Company]
  implicit val encoderUser: Encoder[Company] = deriveEncoder[Company]
}
