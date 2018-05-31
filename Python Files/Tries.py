from typing import Tuple

class TrieNode(object):
    def __init__(self, char: str):
        self.char = char
        self.children = []
        self.wordFinished = False
        self.counter = 1

    def addWord(root, word: str):
        node = root
        foundOrNot = False
        for char in word:
            foundOrNot = False
            for child in node.children:
                if child.char == char:
                    child.counter += 1
                    node = child
                    foundOrNot = True
                    break
            if not foundOrNot:
                newNode = TrieNode(char)
                node.children.append(newNode)
                node = newNode

    def finder(root, word: str) -> Tuple[bool, int]:
        node = root
        if not root.children:
            return False, 0
        for char in word:
            foundOrNot = False
            for child in node.children:
                if child.char == char:
                    foundOrNot = True
                    node = child
                    break
            if not foundOrNot:
                return False, 0
        return True, node.counter


root = TrieNode('*')
root.addWord("apple")
root.addWord("app")
root.addWord("apricots")
root.addWord("appliance")
root.addWord("applause")
print('Looking for "apples"')
print(root.finder('apples'))
print()
print('Looking for "ap"')
print(root.finder('ap'))
