import json
from random import randint

class FeatureRegistry:

    def __init__(self):
        pass

    def page_seo(self, pageStr):
        page = json.loads(pageStr)
        return len(page)

    def count_save_site(self, msid):
        return randint(0, 100)

FeatureRegistry()