package Character_Classes

import org.scalatest.funsuite.AnyFunSuite
class ExperienceTest extends AnyFunSuite {
  test("Level up/ gained exp/ Multiple exp"){
    val character1: Character = new Character(200,140,20,50,30,50,150,100,100,200,300,500,0,5,false)
    assert(character1.start_exp == 200)
    assert(character1.gained_exp == 300)
    assert(character1.earned_exp == 500)
    assert(character1.lvl == 5)
    assert(character1.exp_required_to_lvl_up == 100)
    assert(character1.death_status == false)

    character1.exp_gain(300)
    assert(character1.earned_exp == 100)
    assert(character1.lvl == 8)
  }

}
