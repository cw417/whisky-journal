# whisky-journal

A command line journal for keeping track of whisky inventory and reviews

## Index

- [Usage](#usage)
- [TODO](#todo)
- [Acknowledgments](#acknowledgments)

## Usage

- To run, please compile and run the java files:

  ```bash
  javac *.java
  java UserInterface
  ```

- Enter `help` to see a list of available commands
- Inventory is stored in a csv file, `inventory.csv`

### Inventory System

- `addinv` - add item to invenory
- `clearinv` - clear current inventory
- `delinv` -  delete item from inventory
- `printinv` - print inventory
- `printinvcount` - print inventory, sorted by count
- `reminv` - remove or decrement inventory total for an item
- `searchinv` - search inventory for item(s) by name
- `writeinv` - write current inventory to file

### Journal System

- `addinfo` - add info to an existing entry
- `entry` - create new entry
- `entries` - print entries
- `printentry` - print entry by id number
- `searchname` - search journal for entries with matching name"

## TODO

- Inventory count update needs to be case-independent
- Fix error handling procedures

- Implement entry storage
- Implement entry system
  - add entry with multiple notes
  - add entry update methods
- Change inventory file from test file

## Acknowledgments

Many thanks to my CS professor, Tim McInerney, for the Java knowledge and inspiration.
