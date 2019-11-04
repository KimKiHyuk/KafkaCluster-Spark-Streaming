import java.util.Properties
import org.apache.kafka.clients.producer._

object Main {
    def main(args: Array[String]) {
        val r = scala.util.Random
        while(true) {
            if 
            Producer.sendMessage(r.nextInt(1000).toString)
        }
   }
}


object Producer {
    def sendMessage(message: String) : Unit = {
        println("message - " + message + " was sent")
        val props = new Properties()
        props.put("bootstrap.servers", "localhost:9092")
        // props.put("bootstrap.servers", "localhost:9093")
        // props.put("bootstrap.servers", "localhost:9094")
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
        val producer = new KafkaProducer[String, String](props)
        val record = new ProducerRecord[String, String]("test_topic1", "key", message)
        producer.send(record)
        producer.close()
    }
}