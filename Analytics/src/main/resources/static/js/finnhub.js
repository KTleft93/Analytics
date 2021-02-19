function fetchData() {
	
	//Fetch the JSON file from the url
	fetch('http://api.marketstack.com/v1/eod?limit=20&access_key=YOUR_API_KEY&symbols=MSFT,AAPL,TSLA,FB,INTC,GOOGL,AMZN,NFLX,BABA,V,WMT,NVDA,MA,UNH,ADBE,ORCL,MCD,SBUX,SQ,UBER,GS')
		.then(response => {
		if(!response.ok) {
			throw Error("ERROR");
			
			
		}	
		return response.json();
		
		})
		
		//Take JSON data and display it to console
		.then(data => {
			console.log(data.data);
			
			
			//Map the data to an html element 
			const html = data.data.map(user => {
				return `
				<table class="user">
		
				<tr>
					<td>${user.symbol}</td>
					<td>${user.open}</td>
					<td>${user.high}</td>
					<td>${user.low}</td>
					<td>${user.close}</td>
				</tr>
				
				</table>
				`;
			}).join('');
			console.log(html);
			document
			
				//Render the data to the element with name "prices"
				.querySelector("#prices")
				.insertAdjacentHTML("afterbegin", html);
		});
	
}

fetchData();












