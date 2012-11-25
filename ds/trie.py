
class Tries:
	leaf_char='^'

	"""Data Structure Tries"""
	def __init__(self):
		self.root = {}

	def add_word(self,word):
		word += Tries.leaf_char
		next_level = self.root
 		for letter in word:
			next_level = next_level.setdefault(letter,{})

	def find_word(self,word):
		word += Tries.leaf_char
		next_level = self.root
		for letter in word:
			next_level = next_level.get(letter,None)
			if next_level is None:
				return False
		return True

	def __str__(self):
		import pprint
		return pprint.pformat(self.root)
		

if __name__ == '__main__':
	tries = Tries() 
	words = [ "microsoft", "microscope", "amazon","america","amex","minatory","miracle","micro"]

	for w in words:
		tries.add_word(w)
	print tries

	assert tries.find_word("sexy") is False
	assert tries.find_word("microscope") is True
	assert tries.find_word("mina") is False
	assert tries.find_word("miracle") is True
	assert tries.find_word("micro") is True


