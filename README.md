[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/KprAwj1n)
# APCS - Stuyrim

## Features

Make a clear list of features that work/dont work

:white_check_mark: This feature works.

:question: This feature works partially.

:ballot_box_with_check: This extra (beyond the things that the lab was supposed to do) feature works.

:x: This required feature does not work.

:beetle: This is a bug that affects the game.


## Adventurer Subclasses

|Aspects |Code Warrior|Thief|Brute|
|---|---|---|---|
|Name|Carmack/user|Sophia|Maddie|
|HPMax|30|30|30|
|Special|Caffeine(6/12)|Money(6/12)|Food(6/12)|
|Attack damage|2-7|1-6|3-8|
|Special Attack|Language deals 3-12 damage, reduces caffeine by 8|Health Transfer deals 1-6 damage and restores your hp by the same amount, consumes 2 money|Power deals 5-13 damage and 1/2 is dealt back to you because of recoil, consumes 2 food|
|Support self|1 hp and 6 special|5 hp|6 hp|
|Support other|5 special|5 hp|none|
|Extra||turn steal|critical hit|

### Code Warrior:
- name: [user inputs]
- hp: 30
- special: caffeine
- caffeineMax: 12
- caffeine: 6
- deals 2-7 damage
- special attack: language
  - deals 3-12 damage
- support
  - restores 5 special to other
  - restores 1 hp and 6 special to self

### Thief
- name: sophia
- hp: 30
- special: money
- moneyMax: 12
- money: 6
- deals 1-6 damage
- special attack: health transfer
  - damage dealt transfers to you, consumes 2 money
- support
  - restores 5 hp to self
- extra feature
  - if attack is used 3 times in a row, opponent loses a move (stolen)


### Brute
- name: maddie
- hp: 30
- special: food
- foodMax: 12
- food: 6
- deals 3-8 damage
- special attack: power
  - deals 5-13 damage, ½ applies back on you, consumes 2 food
- support
  - restores 6 hp to self, consumes 2 food
- extra feature
	- if attack is used 3 times in a row, opponent receives a critical hit (special attack + 3)


### Boss
- name: Boss
- hp: 90
- special: fire
- fireMax: 20
- fire: 10
- deals 4-8 damage
- special attack: burn
  - deals 8-12 damage, possible status effect inflicted
- support
  - restores 6 hp and 6 special to self
- extra feature
  - status effect: target may be burned and lose small amounts of hp

### Features

|Feature|Status|
|---|---|
|Display Screen| :white_check_mark: |
|Player moves| :question: |
|quit| :white_check_mark: |
|Enemy moves| :white_check_mark: |
|Death| :white_check_mark: |
|Critical hit(Brute)|:ballot_box_with_check: |
|Move Steal(Thief)| :question: |
|Colored HP| :white_check_mark: |
