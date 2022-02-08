class Buffer:
  private var czynnik: Double = 0
  private var flag = true

  def put(czynnik: Double) = this.synchronized {
    while !flag do wait()
    this.czynnik = czynnik
    flag = false
    notifyAll()
  }

  def take: Double = this.synchronized {
    while flag do wait()
    flag = true
    notifyAll()
    czynnik
  }
end Buffer

var endFlag = false

class Producer2(name: String, buf: Buffer) extends Thread(name) :
  var n: Double = 1
  override def run: Unit =
    while (!endFlag) {
      buf.put(((2 * n) * (2 * n)) / ((2 * n - 1) * (2 * n + 1)))
      n += 1
    }
    println("end producer2")

end Producer2

class Consumer2(name: String, buf: Buffer, dokl: Double) extends Thread(name) :
  var last: Double = 0
  var current: Double = 1

  override def run: Unit =
    while (Math.abs(2*last - 2*current) > dokl) {
      last = current
      current = current * buf.take
    }
    endFlag = true
    println(2 * current)
    buf.take // end producer2
    println("end consumer2")

end Consumer2


def main(): Unit =
  val buf = new Buffer
  var p2 = new Producer2("Producer", buf).start
  var c2 = new Consumer2("Consumer", buf, 0.00000000001).start



