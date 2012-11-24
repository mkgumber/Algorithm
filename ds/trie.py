
class Tries:
	"""Data Structure Tries"""
	def __init__(self):
		self.root = {}

	def add_word(self,word):
		next_level = self.root
 		for letter in w:
			next_level = next_level.setdefault(letter,{})

	def find_word(self,word):
		next_level = self.root
		for letter in word:
			next_level = next_level.get(letter,None)
			if next_level is None:
				return False
		if next_level:
			return False
		else:
			return True

	def __str__(self):
		import pprint
		return pprint.pformat(self.root)
		


tries = Tries() 
words = [ "microsoft", "microscope", "amazon","america","amex","minatory","miracle"]

for w in words:
	tries.add_word(w)
print tries

assert tries.find_word("sexy") is False
assert tries.find_word("microscope") is True
assert tries.find_word("mina") is False
assert tries.find_word("miracle") is True

