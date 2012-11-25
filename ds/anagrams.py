class AnagramFinder():
	"""Simple AnagramFinder"""
	def __init__(self,dictionarylist):
		from collections import defaultdict
		self.anagram_dict = defaultdict(set)
		for w in dictionarylist:
			self.anagram_dict[str(sorted(w))].add(w)

	def find_anagrams(self,word):
		return self.anagram_dict[str(sorted(word))]

	def largest_anagram(self):
		return max(self.anagram_dict.values(),key=lambda x:len(x))

	def __str__(self):
		import pprint
		return pprint.pformat(self.anagram_dict)


if __name__ == '__main__':
	wordlist = [ "pots", "post", "stop", "spot", "opts", "tops","lady","holy","top","pot"]
	my_anagrams = AnagramFinder(wordlist)
	print my_anagrams
	assert my_anagrams.find_anagrams("post") == set(["pots", "post", "stop", "spot", "opts", "tops"])
	assert my_anagrams.largest_anagram() == set(["pots", "post", "stop", "spot", "opts", "tops"])
	assert my_anagrams.find_anagrams("pot") == set( [ "top","pot" ])
		