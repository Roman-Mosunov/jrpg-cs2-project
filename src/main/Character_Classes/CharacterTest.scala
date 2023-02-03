package Character_Classes

//import Character
import org.scalatest.funsuite.AnyFunSuite
class CharacterTest extends AnyFunSuite {
  test("proper HP amount is redused"){
    var character: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    character.takeDamage(25)
    assert(character.current_health_points === 75)
  }
  test("Non-lethal damage"){
    val not_one_shot: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    not_one_shot.takeDamage(50)
    assert( not_one_shot.death_status === false)
  }
  test("one_shot (lethal damage received)"){
    val one_shot: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    one_shot.takeDamage(100)
    assert( one_shot.death_status === true)
  }
  test("Attack_on_Character_physically"){
    val ch1:Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    val ch2:Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    ch1.physical_Attack(ch2)
    assert(ch2.current_health_points === 92)
  }
  test("Attack on Character magically") {
    val ch1: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    val ch2: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    ch1.magic_Attack(ch2, 20)
    assert(ch2.current_health_points === 92)
  }
  test("Magic usage reduces Chakra") {
    val ch1: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    val ch2: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    ch1.magic_Attack(ch2, 20)
    assert(ch1.current_magic_points === 80)
  }
  test("No Chakra - no magic") {
    val ch1: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    val ch2: Character_Classes.Character = new Character_Classes.Character(100,100, 10,2,10,2,100,100,100,0,50,20,0,1,false)
    ch1.current_magic_points = 0
    ch1.magic_Attack(ch2, 20)
    assert(ch2.current_health_points === 100)
  }


}
