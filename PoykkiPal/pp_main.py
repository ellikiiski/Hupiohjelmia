from pathlib import Path
import os

def main():
    print("PöykkiPal auttaa etsimään ikivanhojen pöykkien kätköstä paskaa")
    folder = input("\nAnna yläkansio, jossa pöykit ovat vuosikansiot: ")
    search_string = input("\nAnna etsittävä merkkijono: ")
    print("\n\n")
    search_from_big_folder(search_string, folder)

def list_of_subdirs(folder):
    folders = []
    for path in Path(folder).iterdir():
        if path.is_dir():
            folders.append(path)
    return folders

def search_from_big_folder(search_string, from_big_folder):
    print(F"ETSITÄÄN '{search_string}'\n")
    folders = list_of_subdirs(from_big_folder)
    for folder in folders:
        search_from_folder(search_string, folder)

def search_from_folder(search_string, from_folder):
    files = os.listdir(from_folder)
    for file in files:
        if file.endswith(".txt"):
            file_path = Path(f"{from_folder}/{file}")
            search_from_file(search_string, file_path)

def search_from_file(search_string, from_file):
    with open(from_file) as file:
        lines = file.readlines()
        for line in lines:
            if line.find(search_string) != -1:
                print(f"LÖYTYI TIEDOSTOSTA {from_file}")
                print(f"RIVILTÄ {lines.index(line)}")
                print(f"Koko rivi kuuluu näin: {line}\n")

if __name__ == "__main__":
    main()