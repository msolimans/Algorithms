package utils

//Simple Representation of 2 dimensional array with rows/cols
type TwoDArray struct {
	arr        []interface{}
	rows, cols int
}

func NewTwoDArray(rows, cols int) *TwoDArray {
	arr := make([]interface{}, rows*cols) //all items should be here
	return &TwoDArray{arr, rows, cols}
}

//convert from 2 dimensional space to 1 dimensional space
func (self *TwoDArray) index(x, y int) int {
	return x*self.cols + y
}

func (self *TwoDArray) coord(i int) (x, y int) {
	x = i % self.cols
	y = i / self.cols
	return
}

//should return rows/cols of array
func (self *TwoDArray) Len() (rows, cols int) {
	return self.rows, self.cols
}

//insert specific item at x and y
func (self *TwoDArray) InsertAt(x, y int, val interface{}) {
	self.arr[self.index(x, y)] = val
}

func (self *TwoDArray) GetAt(x, y int) interface{} {
	return self.arr[self.index(x, y)]
}

func (self *TwoDArray) Get() []interface{} {
	return self.arr
}

//M := make([][]uint8, row)
//e := make([]uint8, row * col)
//for i := range M {
//a[i] = e[i * col:(i + 1) * col]
//}
