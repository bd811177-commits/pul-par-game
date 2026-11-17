# પુલ પાર ગેમ — મોબાઇલથી APK બનાવવાની રીત

આ પ્રોજેક્ટમાં GitHub Actions workflow ઉમેરેલું છે. Android ફોનના Chrome બ્રાઉઝરથી GitHub પર અપલોડ કરીને ક્લાઉડમાં APK બનાવી શકાય છે. Android Studio ફોનમાં ઇન્સ્ટોલ કરવાની જરૂર નથી.

## પગલાં
1. ZIP extract કરો (ફોનમાં Files app > Downloads > ZIP > Extract).
2. Chrome માં https://github.com ખોલી મફત account બનાવો અથવા sign in કરો.
3. `+` > New repository પસંદ કરો. નામ `pul-par-game` આપો, Public અથવા Private પસંદ કરો, Create repository કરો.
4. Repository page માં `Add file` > `Upload files` (મوبાઇલમાં browser menu > Desktop site કરવું પડી શકે).
5. Extract કરેલા project folderની **અંદરની બધી ફائلો અને .github folder** અપલોડ કરો. `.github/workflows/build.yml` ખાસ અપલોડ થવું જોઈએ. Folder upload ન થાય તો GitHub browser desktop mode વાપરો.
6. નીચે Commit changes દબાવો. `Actions` tab ખોલો. `Build Android APK` workflow ચાલશે.
7. Build પૂરું થાય પછી Actions > સૌથી ઉપરનો run > Artifacts માં `Pul-Par-Game-APK` ડાઉનલોડ કરો.
8. ZIP artifact extract કરો. `app-debug.apk` પર tap કરીને Install કરો. Android પૂછે તો Chrome/Files ને "Install unknown apps" મંજૂરી આપો.

## નોંધ
- APK debug build છે; વ્યક્તિગત ઇન્સ્ટોલ અને ટેસ્ટ માટે છે.
- GitHub Actions build fail થાય તો Actions run ખોલીને error log મોકલો.
- ગુજરાતી અવાજ Android Text-to-Speechમાં Gujarati voice ઉપલબ્ધ હોય તેના પર આધારિત છે.
- આ ગેમનો code project છે; અહીંથી સીધી APK compile થઈ નથી.
