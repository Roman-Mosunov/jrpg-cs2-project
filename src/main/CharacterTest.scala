package main
import org.scalatest.funsuite.AnyFunSuite
class CharacterTest extends AnyFunSuite {
  test("proper HP amount is redused"){
    var character: Character = new Character(100)
    character.takeDamage(25)
    assert(character.current_health_points === 75)
  }
  test("Non-lethal damage"){
    val not_one_shot: Character = new Character(100)
    not_one_shot.takeDamage(50)
    assert( not_one_shot.dead === false)
  }
  test("one_shot (lethal damage received)"){
    val one_shot: Character = new Character(100)
    one_shot.takeDamage(100)
    assert( one_shot.dead === true)
  }
  test("Attack_on_Character_physically"){
    var ch1:Character = new Character(100)
    var ch2:Character = new Character(100)
    ch1.physical_Attack(ch2)
    assert(ch2.current_health_points === 92)
  }
  test("Attack on Character magically") {
    var ch1: Character = new Character(100)
    var ch2: Character = new Character(100)
    ch1.magic_Attack(ch2, 20)
    assert(ch2.current_health_points === 92)
  }
  test("magic usage reduces Chakra") {
    var ch1: Character = new Character(100)
    var ch2: Character = new Character(100)
    ch1.magic_Attack(ch2, 20)
    assert(ch1.current_magic_points === 80)
  }
  test("No Chakra - no magic") {
    var ch1: Character = new Character(100)
    var ch2: Character = new Character(100)
    ch1.current_magic_points = 0
    ch1.magic_Attack(ch2, 20)
    assert(ch2.current_health_points === 100)
  }

}
