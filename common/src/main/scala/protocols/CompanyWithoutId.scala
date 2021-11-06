package protocols

import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

case class CompanyWithoutId(name: String, email: String, phone: String, workerCount: Int)

object CompanyWithoutId {
  implicit val decoderUser: Decoder[CompanyWithoutId] = deriveDecoder[CompanyWithoutId]
  implicit val encoderUser: Encoder[CompanyWithoutId] = deriveEncoder[CompanyWithoutId]
}
