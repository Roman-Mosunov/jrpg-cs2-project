package Character_Classes
import org.scalatest.funsuite.AnyFunSuite
class PartyTest extends AnyFunSuite {
  test("Party test"){
    val Human1: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 200, 300, 500, 0, 5, false)
    val Human2: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 200, 300, 500, 0, 5, false)

    val Orc1: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 200, 300, 500, 0, 5, false)
    val Orc2: Character = new Character(200, 140, 20, 50, 30, 50, 150, 100, 100, 200, 300, 500, 0, 5, false)

    val Human_party: Character_party = new Character_party(List(Human1,Human2))
    val Orc_party: Character_party = new Character_party(List(Orc1,Orc2))

    Human_party.kill_enemy_party(Orc_party)
    assert(Human1.earned_exp == 250)
    assert(Human2.earned_exp == 250)

    Human1.death_status = true
    Human_party.kill_enemy_party(Orc_party)
    assert(Human1.earned_exp == 250)
    assert(Human2.earned_exp == 350)

  }

}
