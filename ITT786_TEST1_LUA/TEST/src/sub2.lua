require("struct")

file = "SECOND.bin"
fmt = "<!1bi4c2i4"

local a,b,c,d
local out = assert(io.open(file, "wb"))

for i=0,255 do
  -- #x == 11
  local x = struct.pack(fmt, 10, -i, 99, i)
  a,b,c,d = struct.unpack(fmt,x)
  print( a,b,c,d )
  out:write(x)
end
assert(out:close())

local f = assert(io.open(file, "rb"))
local block = 11
while true do
  local bytes = f:read(block)
  if not bytes then break end
  a,b,c,d = struct.unpack(fmt,bytes)
  print( a,b,c,d )
  for b in string.gfind(bytes, ".") do
    io.write(string.format("%02X ", string.byte(b)))
  end
  io.write(string.rep("   ", block - string.len(bytes) + 1))
  io.write(string.gsub(bytes, "%c", "."), "\n")
end

f:close()