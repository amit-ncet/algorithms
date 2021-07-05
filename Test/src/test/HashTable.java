package test;

class HashTable {
	int MAX_SIZE=20;
	Record [] record=new Record[MAX_SIZE];//can support 10 objects
	//Array of record of pre defined size
	
	class Record{
		Object key;
		Object value;
		
		Record(Object key,Object value){
			this.key=key;
			this.value=value;
		}
		
		public Object getKey() {
			return this.key;
		}
		
		public Object getValue() {
			return this.value;
		}
	}
	
		
	void put(Object key,Object value) {
		//System.out.println("Insert item : "+key+" Value :"+value);
		int keyCode=key.hashCode();
		int step=0;
		int index=hash(keyCode,step);
		while(!isEmpty(index)) {
			index=hash(keyCode,++step);
			if(index>=MAX_SIZE || index<0) {
				throw new ArrayIndexOutOfBoundsException("Hashtable is full and it cannot take more items");
			}
		}
		record[index]=new Record(key,value);
		//System.out.println("Record inserted successfully : "+value);
		//System.out.println(record);
	}
	
	Object get(Object key) {
		int keyCode=key.hashCode();
		int step=0;
		int index=hash(keyCode,step);
		while(!isEmpty(index) && record[index].key!=key) {
			index=hash(keyCode,++step);
		}
		return record[index].key==key?record[index].key:null;
	}
	
	boolean isEmpty(int index) {
		//System.out.println("Empty check : "+record[index]+" Index : "+index);
		return record[index]==null;
	}
	
	int hash(int keyCode,int step) {
		int index=0;
		if(step==0) {
			index=(keyCode%MAX_SIZE);
			System.out.println("Index : "+index);
		}else {
			index=(keyCode%MAX_SIZE+step*step)%MAX_SIZE;
			System.out.println("Collision occured : "+index);
		}
		return index;
	}
	
	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder("{ ");
		for(int i=0;i<MAX_SIZE;i++) {
			if(record[i]!=null)
			sb.append(record[i].key+":"+record[i].value+",");
		}
		sb.append(" }");
		return sb.toString();
	}
	
}