from os.path import exists
import json

# TODO:
# - make arguments optional for class?
# - set up sqlalchemy
# - move data to database
# - implement search functions based on info

class Entry:
  def __init__(self, name, whisky_type, abv, nose, palate, finish):
    self.name = name
    self.whisky_type = whisky_type
    self.abv = abv
    self.nose = ["pear", "apple", "vanilla"]
    self.palate = ["butter", "shortbread", "vanilla"]
    self.finish = ["apple", "butter", "cream"]

  def print_info(self):
    """Prints formatted object info"""
    print(f"Name: {self.name}")
    print(f"Type: {self.whisky_type}")
    print(f"ABV/Proof: {self.abv}%/{self.abv * 2} proof")
  
  def print_notes(self):
    """Prints out nose, palate, finish"""
    print(f"Nose: {self.nose}")
    print(f"Palate: {self.palate}")
    print(f"Finish: {self.finish}")

def introduction():
  """Prints introduction for the app"""
  print("Hello, welcome to whisky-journal.")
  print("Enter 'q' at any time to quit.")

def create_entry(name):
  """Creates new entry class object"""
  entry = Entry(name)
  print(f"Created: {entry.name}")

## may use sqlalchemy instead of json
#
#def write_to_json(entry):
#  """Writes new entry to json file"""
#  filename = "whisky.json"
#  
#  data = {
#    entry.name: [
#    "whisky_type": entry.whisky_type,
#    "abv": entry.abv,
#    "nose": entry.nose,
#    "palate": entry.palate,
#    "finish": entry.finish
#    ]
#    }
#
#  if exists(filename):
#    with open(filename, 'a') as outfile:
#      json.dump(data, outfile, indent=4)
#    print(f"Entry written: {entry.name}")
#  else:
#    with open(filename, 'w') as outfile:
#      json.dump(data, outfile, indent=4)
#    print(f"File created: '{filename}'")

def test():
  nose = ["pear", "apple", "vanilla"]
  palate = ["butter", "shortbread", "vanilla"]
  finish = ["apple", "butter", "cream"]
  ys = Entry("Yellow Spot", "Irish", 46.0, nose, palate, finish)
  ys.print_info()
  ys.print_notes()

if __name__ == '__main__':
  introduction()
  test()