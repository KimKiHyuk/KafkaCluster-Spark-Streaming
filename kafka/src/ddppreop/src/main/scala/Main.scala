object Main extends App {
    import java.util.Properties
    import org.apache.kafka.clients.producer._
    println("Hello,")
    val props = new Properties()
    props.put("bootstrap.servers", "localhost:9092")
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
    val producer = new KafkaProducer[String, String](props)
    val record = new ProducerRecord[String, String]("test_topic", "key", "value")
    producer.send(record)
    producer.close()
}