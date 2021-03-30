-- 613. Shortest Distance in a Line
-- Table point holds the x coordinate of some points on x-axis in a plane, which are all integers.
--
--
-- Write a query to find the shortest distance between two points in these points.
--
--
-- | x   |
-- |-----|
-- | -1  |
-- | 0   |
-- | 2   |
--
--
-- The shortest distance is '1' obviously, which is from point '-1' to '0'. So the output is as below:
--
--
-- | shortest|
-- |---------|
-- | 1       |
--
--
-- Note: Every point is unique, which means there is no duplicates in table point.
--
--
-- Follow-up: What if all these points have an id and are arranged from the left most to the right most of x axis?

# Write your MySQL query statement below
SELECT min(abs(a.x - b.x)) shortest
FROM point a, point b
WHERE a.x > b.x

#Follow-up: What if all these points have an id and are arranged from the left most to the right most of x axis?
--calc the absolute difference between each point and its adjacent one [current position +1 will refer to the next point]
--output the minimum diff
SELECT min(abs(a.x - b.x)) shorted from point a join point b on a.id = b.id + 1


