# e_596_ClassesMoreThan5Students 

# Tags
# SQL 
#

/*Description
******************************************************************************************************************

There is a table courses with columns: student and class

Please list out all classes which have more than or equal to 5 students.

For example, the table:

+---------+------------+
| student | class      |
+---------+------------+
| A       | Math       |
| B       | English    |
| C       | Math       |
| D       | Biology    |
| E       | Math       |
| F       | Computer   |
| G       | Math       |
| H       | Math       |
| I       | Math       |
+---------+------------+
Should output:

+---------+
| class   |
+---------+
| Math    |
+---------+


Note:
The students should not be counted duplicate in each course.


******************************************************************************************************************
Companies: N/A
******************************************************************************************************************
Link: https://leetcode.com/problems/classes-more-than-5-students/
******************************************************************************************************************
*/

# Write your MySQL query statement below

SELECT s.class
FROM
(SELECT distinct class, student FROM courses) s /*distinct is used to filter unique classes and students, below is an example of duplications */
GROUP BY s.class
having count(*) >= 5


# {"headers": {"courses": ["student", "class"]}, "rows": {"courses":
# [["A", "Math"],
#  ["B", "English"],
#  ["C", "Math"],
#  ["D", "Biology"],
#  ["E", "Math"],
#  ["F", "Math"],
["A", "Math"]]}}

# with the a bove concept, this can be abbreviated in one sql query:

SELECT class
FROM courses
GROUP BY class
having count(distinct student) >= 5



