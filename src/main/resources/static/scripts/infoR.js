let infoPage = document.querySelector("#mainInfo");

infoPage.style.paddingTop = "20px"

//fetch data from the database using the api
document.addEventListener('DOMContentLoaded', ()=>{
    fetch('/api/toiletblocks')
    .then(response => response.json())
    .then (responseData =>{ console.log(responseData)
        for (const block of responseData) {
        const container = document.createElement('div');
        container.className = "block-container";
        container.style.marginBottom = "2em";

        //information about the block, in a non tabular form
        const blockHeader = document.createElement('h3');
        blockHeader.textContent = `Block ID: ${block.blockId} | Address: ${block.blockAddress} | Status: ${block.blockStatus} | Toilets: ${block.toiletCount}`;
        container.appendChild(blockHeader);
        

        //creating the table
        const table = document.createElement('table');
        //css styles for the table
        table.style.width = "100%";
        table.style.borderCollapse = "collapse";
        table.style.marginTop = "0.5em";

        // header of the table
        const tableHead = document.createElement('thead');
        const headerRow = document.createElement('tr');
        ['Toilet ID', 'Block ID', 'Toilet Status'].forEach(headerText => {
          const th = document.createElement('th');
          th.textContent = headerText;
          //css styles for the table header row
          th.style.fontSize = "22px";
          th.style.border = "4px solid #ccc";
          th.style.padding = "8px";
          th.style.backgroundColor = "#0096C7"; //blue bg with black fg
          headerRow.appendChild(th);
    });
        tableHead.appendChild(headerRow);
        table.appendChild(tableHead);

        //content of table
        const tbody = document.createElement('tbody');

        if (block.toilets && block.toilets.length > 0) {
          for (const toilet of block.toilets) {
            const row = document.createElement('tr');

            //forEach to call a function for all the toilets infos in the array
            [toilet.toiletId, toilet.blockId, toilet.toiletStatus].forEach(celltext => {
              const td = document.createElement('td');

              td.textContent = celltext;
              //css styles for the rows and columns
              td.style.fontSize = "25px";
              td.style.border = "4px solid #ccc";
              td.style.padding = "8px";
              td.style.backgroundColor = "#bcc8d0";
              row.appendChild(td);
                
              //using color indicators to show the toiletStatus
              if(toilet.toiletStatus == "Vacant"){
                td.style.backgroundColor = "#90EE90"
              }else{
                td.style.backgroundColor = "red"
              }
        });

            tbody.appendChild(row);
          }
        } else {
          const row = document.createElement('tr');
          const td = document.createElement('td');
          td.colSpan = 3;
          td.textContent = "No toilets available in this block.";
          //css styles for the rows and columns
          td.style.fontSize = "23px";
          td.style.border = "4px solid #ccc";
          td.style.padding = "8px";
          td.style.textAlign = "center";
          td.style.backgroundColor = "#bcc8d0";
          row.appendChild(td);
          tbody.appendChild(row);
    }

        table.appendChild(tbody);
        container.appendChild(table);
        infoPage.appendChild(container);
      }
    
    })
        .catch(error => console.error("Error fetching JSON data:", error));

});
