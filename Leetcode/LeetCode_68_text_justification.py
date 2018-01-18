class Solution(object):
    def fullJustify(self, words, maxWidth):
        """
        :type words: List[str]
        :type maxWidth: int
        :rtype: List[str]
        """
        if len(words) == 0:
            return []
        count = []
        for word in words:
            count.append(len(word))
        print count
        res = []
        j = 0
        while j<len(words):
            path = []
            l = 0
            space = 0
            num_letters = 0
            while l<maxWidth and j<len(words):
                l += count[j]
                if l > maxWidth:
                    break
                num_letters += count[j]
                path.append(words[j])
                j += 1
                l += 1
            space += maxWidth - num_letters
            if  j==0:
                return [""]
            if len(path) > 1:
                each = space/(len(path)-1)
                rem = space%(len(path)-1)
            s = ""
            if j<len(words):
                for i in xrange(len(path)-1):
                    if rem:
                        s += path[i] + " "*each + " "
                        rem -= 1
                    else:
                        s += path[i] + " "*each
                if len(path) != 0:
                    s += path[len(path)-1]
            else:
                for k in xrange(len(path)-1):
                    s += path[k] + " "
                if len(path) != 0:
                    s += path[len(path)-1]
            if len(s) < maxWidth:
                s += " "*(maxWidth-len(s))
            res.append(s)
        return res