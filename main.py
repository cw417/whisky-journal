
class Entry:
  def __init__(self, name, whisky_type, abv):
    self.name = name
    self.whisky_type = whisky_type
    self.abv = abv
    self.nose = ["pear", "apple", "peach"]
    self.palate = []
    self.finish = []

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

def create_json():
  """Creates new json file if none present"""

def write_to_json():
  """Writes new entry to json file"""


if __name__ == '__main__':
  introduction()
  ys = Entry("Yellow Spot", "Irish", 46.0)
  ys.print_info()
  ys.print_notes()