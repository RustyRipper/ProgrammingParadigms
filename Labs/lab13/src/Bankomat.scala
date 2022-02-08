class Bankomat:
  private var aktualnaIlosc: Int = 500
  private var flag = true

  def put(ilosc: Int) = this.synchronized {
    while (!flag) do {
      wait()
    }

    aktualnaIlosc += ilosc
    println(s"${Thread.currentThread.getName} uzupelniono: $ilosc")
    println(s"Aktualny Stan: $aktualnaIlosc")
    flag = false
    notifyAll()
  }

  def take(iloscDoWyplaty: Int): Int = this.synchronized {
    while (flag) do {
      wait()
    }

    while (iloscDoWyplaty > aktualnaIlosc) {
      flag = true
      notifyAll()
      println(s"${Thread.currentThread.getName} ,za malo w bankomacie, czeka")
      wait()
    }
    if (this.aktualnaIlosc <= 0) {
      flag = true
      notifyAll()
    }
    aktualnaIlosc -= iloscDoWyplaty // returm message
    println(s"${Thread.currentThread.getName} wyplaca: $iloscDoWyplaty")
    println(s"W bankomacie zostalo: $aktualnaIlosc")
    iloscDoWyplaty
  }


class Producer(name: String, bankomat: Bankomat) extends Thread(name) :
  override def run: Unit =
    for i <- 1 to 100 do
      bankomat.put(200)


class Consumer(name: String, bankomat: Bankomat, iloscDoWyplaty: Int) extends Thread(name) :
  override def run: Unit =
    val wybraneSrodki = bankomat.take(iloscDoWyplaty)
    println(s"${Thread.currentThread.getName} mam w portfelu $wybraneSrodki")



def test(): Unit =
  val bankomat = new Bankomat
  new Producer("Producer", bankomat).start
  new Consumer("Marcin", bankomat, 100).start
  new Consumer("Bartek", bankomat, 200).start
  new Consumer("Andrzej", bankomat, 300).start
  new Consumer("Jan", bankomat, 400).start