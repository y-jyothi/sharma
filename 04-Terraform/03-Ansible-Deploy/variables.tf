variable "key_name" {
  default = "hospital"
}

variable "pvt_key" {
  default = "/root/.ssh/hospital.pem"
}

variable "us-east-zones" {
  default = ["us-east-1a", "us-east-1b"]
}

variable "sg-id" {
  default = "sg-0a8263b9bf1690a1f"
}
