import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.kafka010._
import org.apache.spark.streaming.kafka010.LocationStrategies.PreferConsistent
import org.apache.spark.streaming.kafka010.ConsumerStrategies.Subscribe
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.apache.kafka.common.serialization.StringDeserializer
import org.apache.spark.streaming.StreamingContext
import org.apache.spark._
import org.apache.spark.streaming._
import org.apache.spark.streaming.Seconds

object kafkar {
  def main(args: Array[String]) {

    
val kafkaParams = Map[String, Object](
  "bootstrap.servers" -> "kafka1",
  "key.deserializer" -> classOf[StringDeserializer],
  "value.deserializer" -> classOf[StringDeserializer]
  //  "group.id" -> "use_a_separate_group_id_for_each_stream",
  //  "auto.offset.reset" -> "latest",
  //  "enable.auto.commit" -> (false: java.lang.Boolean)
  )
  //val ssc = new StreamingContext(sc, Seconds(1))
  val topics = Array("spark_topic_2")
  val conf = new SparkConf().setMaster("local[1]").setAppName("kafka")
  val ssc = new StreamingContext(conf, Seconds(1))
  val stream = KafkaUtils.createDirectStream[String, String](
    ssc,
    PreferConsistent,
    Subscribe[String, String](topics, kafkaParams)
  )
    println("test result i`s")
    println(stream.map(record => (record.key, record.value)))

  }
}