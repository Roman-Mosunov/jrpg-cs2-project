package main
class Character(var points: Int){
  var max_health_points: Int = 1000
  var current_health_points: Int = 100
  var attack_power: Int = 10
  var defence:Int = 2
  var magic_attack:Int = 10
  var magic_defence:Int = 2
  var max_magic_points:Int = 1000
  var current_magic_points:Int = 100
  var dead: Boolean = false

  def takeDamage(damage: Int): Unit = {
    current_health_points -= damage
    if (current_health_points <= 0) {
      dead = true
    }

  }

  def physical_Attack(anotherChar:Character):Unit ={
    val ph_damage = attack_power - anotherChar.defence
    anotherChar.takeDamage(ph_damage)
  }

  def magic_Attack(anotherChar:Character, magic_point_cost: Int): Unit= {
    if(current_magic_points >= magic_point_cost){
      current_magic_points -= magic_point_cost
      val mag_damage = magic_attack - anotherChar.magic_defence
      anotherChar.takeDamage(mag_damage)
    }

  }

}
