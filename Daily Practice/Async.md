<Input
    label="Title"
    register={register('title', {
        validate: {
            unavailable: async (value) => {
                try {
                    const results = await existsByTitle(value);
                    const isAlreadyExists = results.data;

                    console.info('isAlreadyExists: ', isAlreadyExists);
                    
                    return isAlreadyExists ? 'Sorry, title already exists!' : true;
                } catch (error) {
                    console.error('Error checking title availability:', error);
                    return false;
                }
            }
        }
    })}
/>


 <Input label="Title" register={register('title', {
            validate: {
                unavailable: (value) => {
                    let isAlreadyExists = false;

                    existsByTitle(value).then(results => {
                        isAlreadyExists = results.data
                        
                    }).catch(error => {
                        isAlreadyExists = false;
                    })
                    console.info('isAlreadyExists: ', isAlreadyExists);
                    return isAlreadyExists ? 'Sorry, title is already exists!' : true;;
                }
            }
        }

        )} errors={errors} />




<Input label="Title" errors={errors} register={register('title', {
            validate: {
                unavailable: (value) => {
                    let isAlreadyExists = true;
                    existsByTitle(value).then(results => {
                        isAlreadyExists = results.data
                        console.info('Inside: THEN : ', isAlreadyExists);
                        return isAlreadyExists ? 'Sorry, title is already exists!' : true;
                    }).catch(error => {
                        isAlreadyExists = false;
                    })
                    console.info('Outside: THEN : ', isAlreadyExists);
                    return isAlreadyExists ? 'Sorry, title is already exists!' : true;
                }
            }
        }
        )} />



<Input label="Title" errors={errors} register={register('title', {
            validate: {
                unavailable: async (value) => {
                    try {
                        const results = await existsByTitle(value);
                        const isAlreadyExists = results.data;
                        console.info('Inside: THEN : ', isAlreadyExists);
                        return isAlreadyExists ? 'Sorry, title is already exists!' : true;
                    } catch (error) {
                        console.error(error);
                        return false;
                    }
                }
            }
        }
        )} />











