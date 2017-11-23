package utils


type TwoDArray struct{
	arr []interface{}
	rows, cols int

}

func New(rows,cols int) *TwoDArray{
	arr := make([]interface{}, rows * cols) //all items should be here
	return &TwoDArray{ arr, rows, cols }
}

func (self *TwoDArray) index(i,j int) int{
	return i*self.cols+j;
}

func (self *TwoDArray) InsertAt(i, j int, val interface{}) {
	self.arr[self.index(i,j)] = val
}

func (self *TwoDArray) GetAt(i,j int) interface{}{
	return self.arr[i*self.cols + j]
}


//M := make([][]uint8, row)
//e := make([]uint8, row * col)
//for i := range M {
//a[i] = e[i * col:(i + 1) * col]
//}