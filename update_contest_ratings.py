import requests

username = "AshikaGupta_01"

query = """
{
  userContestRankingHistory(username: "%s") {
    contest { title startTime }
    rating
  }
}
""" % username

res = requests.post("https://leetcode.com/graphql", json={"query": query}).json()
# Process res to generate table
