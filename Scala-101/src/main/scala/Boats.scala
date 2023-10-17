object Boats extends App{
  class Boat{
    val length: Int = 30
    val width: Int = 22
    val topSpeed: Int = 50
    def isFasterThan(anotherBoat: Boat): Boolean = anotherBoat.topSpeed > topSpeed
    val isFaster: Boat => Boolean = (anotherBoat: Boat) => anotherBoat.topSpeed > topSpeed
  }

  class SailBoat extends Boat{
    val numSails: Int = 5
    val hasOars: Boolean = true
    val canTrack: Boolean = false
  }

  class MotorBoat extends Boat{
    val engineSize: Int = 100
    val fuelType: String = "Diesel"
  }

  class LuxurySailBoat extends SailBoat with RenownedDesigner {
    val hasJacuzzi: Boolean = true
    val hasBooze: Boolean = true
  }

  class PirateShip extends SailBoat with Artillery {
    val numGangPlanks = 5
    def canOutgun(anotherShip: PirateShip): Boolean = anotherShip.numGuns * anotherShip.range > numGuns * range
  }

  class WarShip extends MotorBoat with Artillery with RenownedDesigner {
    val country: String = "England"
  }

  class PacerBoat extends MotorBoat{
    val sponsor: String = "Santander"
    val quarterMileTime: Double = 7.68

    def sponsorCheck(anotherBoat: PacerBoat): String = {
      if (anotherBoat.sponsor == null) "You're going to need some more money for this" else "How fast is this thing?"
    }
  }

  trait Artillery{
    val numGuns: Int = 4
    val range: Int = 70
  }

  trait RenownedDesigner{
    val name: String = "Some Designer"
    val location: String = "England"
  }

  val x: WarShip = new WarShip()
  println(s"${x.country}'s ships *slaps the roof* can reach speeds like ${x.topSpeed} knots! It was made by ${x.name} after all.")
  val y: PacerBoat = new PacerBoat()
  val z: PirateShip = new PirateShip()

}