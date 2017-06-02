file = io.open("FIRST.txt","r")
for line in file:lines() do
  print(line)
end
file:close()
