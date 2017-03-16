package il.co.topq.externalframeworks;

public enum Month {
	Jan, Feb, Mar, Apr, May, Jun, Jul, Aug, Sep, Oct, Nov, Dec;
	
	public Month getNextMonth(Month month)
	{
		if(month == Month.Dec)
		{
			return Jan;
		}
		else
		{
			return Month.values()[month.ordinal() + 1];
		}
	}
}
