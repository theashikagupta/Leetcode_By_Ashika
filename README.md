# 🚀 LeetCode Contest Ratings & Problem Stats

This repository contains my **LeetCode solutions** along with **contest performance tracking**.  
All contest ratings are automatically updated using a Python script and GitHub Actions.

---

## 🏆 LeetCode Stats

![Leetcode Stats](https://leetcard.jacoblin.cool/AshikaGupta_01?ext=activity)

---

## 📊 Contest Ratings

| Contest Name        | Date      | Rating | Change |
|-------------------- |-----------|--------|--------|
| Weekly Contest 465  | 2025-08-31| 1518   |        |
| Weekly Contest 466  | 2025-09-07|        |        |  

> ⚡ This table is automatically updated after every contest using a **Python script + GitHub Action**.

---

## ⚙️ How It Works

1. The Python script `update_contest_ratings.py` fetches your latest contest ratings from LeetCode.
2. GitHub Action runs the script weekly or manually via workflow dispatch.
3. The script updates the **Contest Ratings table** in README automatically.
4. No manual edits are required for future contests.

---

## 📝 Instructions

- To manually trigger an update, go to the **Actions** tab in your GitHub repository and run the workflow: **Update LeetCode Contest Ratings**.
- Make sure your LeetCode username in the script is set correctly:

```python
username = "AshikaGupta_01"
