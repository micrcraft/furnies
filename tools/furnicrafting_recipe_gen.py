import os
import json

# Define the templates for recipes
def get_bench_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 2,
                "item": "minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_bench",
            "count": 2
        }
    }

def get_stone_path_recipe(stone):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{stone}"
            }
        ],
        "result": {
            "id": f"furnies:{stone}_path",
            "count": 4
        }
    }

def get_bench_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 2,
                "item": "minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_bench",
            "count": 2
        }
    }

def get_wood_chair_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 2,
                "item": "minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_chair",
            "count": 2
        }
    }

def get_wood_table_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 2,
                "item": "minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_table",
            "count": 2
        }
    }

def get_support_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_support",
            "count": 1
        }
    }

def get_decorative_stairs_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_decorative_stairs",
            "count": 1
        }
    }


def get_lamp_recipe(color):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{color}_wool"
            },
            {
                "count": 1,
                "item": f"minecraft:glowstone_dust"
            }
        ],
        "result": {
            "id": f"furnies:{color}_lamp",
            "count": 1
        }
    }

def get_cabinet_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_cabinet",
            "count": 1
        }
    }

def get_bar_counter_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 1,
                "item": f"minecraft:calcite"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_bar_counter",
            "count": 1
        }
    }

def get_stool_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 2,
                "item": f"minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_stool",
            "count": 2
        }
    }

def get_kitchen_cabinet_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_kitchen_cabinet",
            "count": 2
        }
    }

def get_kitchen_sink_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 1,
                "item": f"minecraft:quartz_block"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_kitchen_sink",
            "count": 2
        }
    }

def get_kitchen_drawer_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 1,
                "item": f"minecraft:quartz_block"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_kitchen_drawer",
            "count": 2
        }
    }


def get_kitchen_cabinetry_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            },
            {
                "count": 1,
                "item": f"minecraft:quartz_block"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_kitchen_cabinetry",
            "count": 1
        }
    }

def get_sofa_recipe(color):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 3,
                "item": f"minecraft:{color}_wool"
            },
            {
                "count": 2,
                "item": "minecraft:stick"
            }
        ],
        "result": {
            "id": f"furnies:{color}_sofa",
            "count": 1
        }
    }

def get_drawer_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_drawer",
            "count": 1
        }
    }

def get_wood_path_recipe(wood):
    return {
        "type": "furnies:furni_crafting",
        "materials": [
            {
                "count": 1,
                "item": f"minecraft:{wood}_planks"
            }
        ],
        "result": {
            "id": f"furnies:{wood}_wood_path",
            "count": 4
        }
    }

# Function to save JSON data to a file
def save_json_file(path, data):
    os.makedirs(os.path.dirname(path), exist_ok=True)
    with open(path, "w", encoding="utf-8") as f:
        json.dump(data, f, indent=4)

# Main function
def generate_recipes():
    # Read colors and woods from the JSON files
    script_dir = os.path.dirname(os.path.abspath(__file__))
    colors_file = os.path.join(script_dir, "colors.json")
    stones_file = os.path.join(script_dir, "stones.json")
    woods_file = os.path.join(script_dir, "woods.json")

    with open(colors_file, "r", encoding="utf-8") as f:
        colors = json.load(f)

    with open(woods_file, "r", encoding="utf-8") as f:
        woods = json.load(f)

    with open(stones_file, "r", encoding="utf-8") as f:
        stones = json.load(f)

    # Base directory for recipes
    base_dir = os.path.join(script_dir, "furnies", "recipes")

    for stone in stones:
        stone_path = os.path.join(base_dir, f"{stone}_path.json")
        save_json_file(stone_path, get_stone_path_recipe(stone))


    # Generate recipes for each color
    #for color in colors:
        #sofa = os.path.join(base_dir, f"{color}_sofa.json")
        #save_json_file(sofa, get_sofa_recipe(color))

        #lamp = os.path.join(base_dir, f"{color}_lamp.json")
        #save_json_file(lamp, get_lamp_recipe(color))

    # Generate recipes for each wood type
    for wood in woods:
        bench = os.path.join(base_dir, f"{wood}_bench.json")
        save_json_file(bench, get_bench_recipe(wood))

        # drawer = os.path.join(base_dir, f"{wood}_drawer.json")
        # save_json_file(drawer, get_drawer_recipe(wood))

        # wood_path = os.path.join(base_dir, f"{wood}_wood_path.json")
        # save_json_file(wood_path, get_wood_path_recipe(wood))

        #table = os.path.join(base_dir, f"{wood}_table.json")
        #save_json_file(table, get_wood_table_recipe(wood))

        #support = os.path.join(base_dir, f"{wood}_support.json")
        #save_json_file(support, get_support_recipe(wood))

        #decorative_stair = os.path.join(base_dir, f"{wood}_decorative_stairs.json")
        #save_json_file(decorative_stair, get_decorative_stairs_recipe(wood))

        #cabinet = os.path.join(base_dir, f"{wood}_cabinet.json")
        #save_json_file(cabinet, get_cabinet_recipe(wood))

        #bar_counter = os.path.join(base_dir, f"{wood}_bar_counter.json")
        #save_json_file(bar_counter, get_bar_counter_recipe(wood))

        #stool = os.path.join(base_dir, f"{wood}_stool.json")
        #save_json_file(stool, get_stool_recipe(wood))

        #kitchen_cabinet = os.path.join(base_dir, f"{wood}_kitchen_cabinet.json")
        #save_json_file(kitchen_cabinet, get_kitchen_cabinet_recipe(wood))

        #kitchen_sink = os.path.join(base_dir, f"{wood}_kitchen_sink.json")
       # save_json_file(kitchen_sink, get_kitchen_sink_recipe(wood))

        #kitchen_drawer = os.path.join(base_dir, f"{wood}_kitchen_drawer.json")
        #save_json_file(kitchen_drawer, get_kitchen_drawer_recipe(wood))

        #kitchen_cabinetry = os.path.join(base_dir, f"{wood}_kitchen_cabinetry.json")
        #save_json_file(kitchen_cabinetry, get_kitchen_cabinetry_recipe(wood))

if __name__ == "__main__":
    generate_recipes()
