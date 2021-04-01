const fs = require('fs');
const fileName = 'sample-json.json';
const file = require(fileName);
    
file.key = "data";
    
fs.writeFile(fileName, JSON.stringify(file), function writeJSON(err) {
  if (err) return console.log(err);
  console.log(JSON.stringify(file));
  console.log('writing to ' + fileName);
});