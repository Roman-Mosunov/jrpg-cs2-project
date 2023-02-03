package Character_Classes

class Character(
  var max_health_points: Int,
  var current_health_points: Int,
  var attack_power: Int,
  var defence:Int,
  var magic_attack:Int,
  var magic_defence:Int,
  var max_magic_points:Int,
  var current_magic_points:Int,
  var exp_required_to_lvl_up: Int = 100,
  var start_exp:Int,
  var gained_exp: Int,
  var earned_exp:Int,
  var party_exp: Int,
  var lvl:Int,
  var death_status: Boolean
  ){

  def takeDamage(damage: Int): Unit = {
    current_health_points -= damage
    if (current_health_points <= 0) {
      death_status = true
    }

  }

  def physical_Attack(enemy_character:Character):Unit ={
    val ph_damage = attack_power - enemy_character.defence
    enemy_character.takeDamage(ph_damage)
  }

  def magic_Attack(enemy_character:Character, magic_point_cost: Int): Unit= {
    val magic_damage = magic_attack - enemy_character.defence
    if(current_magic_points >= magic_point_cost){
      current_magic_points -= magic_point_cost
      val mag_damage = magic_attack - enemy_character.magic_defence
      enemy_character.takeDamage(magic_damage)
    }

  }
  def level_up():Unit ={
    if (death_status == false){
      while (exp_required_to_lvl_up < earned_exp){
        earned_exp -= exp_required_to_lvl_up
        lvl += 1
        exp_required_to_lvl_up *= 2
        attack_power *= 2
        defence *= 2
        magic_defence *= 2
        magic_attack *= 2
        max_health_points *= 2
      }

    }

  }
  def exp_gain(added_exp: Int):Unit= {
    if (death_status == true) {
      earned_exp = 0
    }
    else if (death_status == false) {
      earned_exp += added_exp
      if (earned_exp > exp_required_to_lvl_up) {
        level_up()
      }

    }

  }
  def battleOptions():List[String]={
   val battle_options = List("Physical Attack","Magic Attack","Heal","Use Ulta")
     battle_options.take(4)
  }
  def takeAction(action: String, character: Character): Unit={
    val available_battle_options = battleOptions()
    if (available_battle_options.contains(action)){

    }
  }
  class Warrior(var max_hp: Int,var current_health: Int,var attackpower: Int,var defense_power: Int,var magicattack: Int,var magic_defense: Int,var max_magicpoints: Int,var current_magicpoints: Int,var starting_experience: Int,var gained_experience: Int,var earned_experience: Int,var party_experience: Int,var character_level: Int,var character_death_status: Boolean)
    extends Character(max_hp, current_health, attack_power, defense_power: Int, magic_attack, magic_defense, max_magic_points, current_magic_points, 100, starting_experience, gained_experience, earned_experience, party_experience, character_level, character_death_status) {

    override def battleOptions(): List[String] = {
      List("Physical Attack", "Defend", "Charge Attack")
    }

    override def takeAction(action: String, target: Character): Unit = {
      action match {
        case "Physical Attack" => physicalAttack(target)
        case "Defend" => defend()
        case "Use item" => charge_attack()
        case "Use Ult" => ult()
        case _ => println("Invalid action")
      }
    }

    def physicalAttack(target: Character): Unit = {
      target.current_health_points -= attack_power - target.defence
    }

    def defend(): Unit = {
       defense_power += 10
    }

    def charge_attack(): Unit = {
      attack_power += 30
    }

    def ult(): Unit = {

    }
    override def level_up(): Unit = {
      super.level_up()
      attack_power += 2
      defense_power += 2
      if (character_level >= 5) {
        battleOptions() :+ "Use Ult"
      }
    }
  }

  class Wizzard(var max_hp: Int, var current_health: Int, var attackpower: Int, var defense_power: Int, var magicattack: Int, var magic_defense: Int, var max_magicpoints: Int, var current_magicpoints: Int, var starting_experience: Int, var gained_experience: Int, var earned_experience: Int, var party_experience: Int, var character_level: Int, var character_death_status: Boolean)
    extends Character(max_hp, current_health, attack_power, defense_power: Int, magic_attack, magic_defense, max_magic_points, current_magic_points, 100, starting_experience, gained_experience, earned_experience, party_experience, character_level, character_death_status) {

    override def battleOptions(): List[String] = {
      List("Magic Attack", "Defend", "Heal")
    }

    override def takeAction(action: String, target: Character): Unit = {
      action match {
        case "Physical Attack" => physicalAttack(target)
        case "Defend" => defend()
        case "Heal" => charge_attack()
        case "Use Ult" => ult()
        case _ => println("Invalid action")
      }
    }

    def physicalAttack(target: Character): Unit = {
      target.current_health_points -= attack_power - target.defence
    }

    def defend(): Unit = {
      defense_power += 10
    }

    def charge_attack(): Unit = {
      attack_power += 30
    }

    def ult():Unit = {

    }
    override def level_up(): Unit = {
      super.level_up()
      attack_power += 2
      defense_power += 2
      if (character_level >= 5) {
        battleOptions() :+ "Use Ult"
      }
    }
  }
}

